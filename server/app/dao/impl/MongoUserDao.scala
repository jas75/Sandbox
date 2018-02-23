package dao.impl

import java.util.UUID
import javax.inject.Inject

import com.mohiva.play.silhouette.api.LoginInfo
import dao.UserDao
import models.{Profile, User}
import play.libs.Json
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.Future

class MongoUserDao @Inject() (reactiveMongoApi: ReactiveMongoApi) extends UserDao {
  // use @Inject annotation
  //lazy val reactiveMongoApi = play.api.Play.current.injector.instanceOf[ReactiveMongoApi]
  //val users = reactiveMongoApi.db.collection[JSONCollection]("users")
  val users = reactiveMongoApi.db.collection[JSONCollection]("users")

  def find(loginInfo: LoginInfo): Future[Option[User]] =
    users.find(Json.obj("profiles.loginInfo" -> loginInfo)).one[User]

  def find(userId: UUID):Future[Option[User]] =
    users.find(Json.obj("id" -> userId)).one[User]

  def save(user: User): Future[User] =
    users.insert(user).map(_ => user)

  def confirm(loginInfo: LoginInfo): Future[User] = for {
    _ <- users.update(Json.obj(
      "profiles.loginInfo" -> loginInfo
    ), Json.obj("$set" -> Json.obj("profiles.$.confirmed" -> true)))
    user <- find(loginInfo)
  } yield user.get

  def link(user: User, profile: Profile) = for {
    _ <- users.update(Json.obj("id" -> user.id), Json.obj("$push" -> Json.obj("profiles" -> profile)))
    user <- find(user.id)
   } yield user.get

  def update(profile:Profile) = for {
    _ <- users.update(Json.obj(
      "profiles.loginInfo" -> profile.loginInfo
    ), Json.obj("$set" -> Json.obj("profiles.$" -> profile)))
    user <- find(profile.loginInfo)
  } yield user.get
}
