package dao

import java.util.UUID

import com.mohiva.play.silhouette.api.LoginInfo
import models.{Profile, User}

import scala.concurrent.Future

trait UserDao {
  def save(user: User): Future[User]
  def find(loginInfo: LoginInfo): Future[Option[User]]
  def find(userId: UUID): Future[Option[User]]
  def confirm(loginInfo: LoginInfo): Future[User]
  def link(user: User, profile: Profile): Future[User]
  def update(profile: Profile): Future[User]
}
