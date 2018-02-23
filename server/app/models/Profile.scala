package models

import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.util.PasswordInfo
import com.mohiva.play.silhouette.impl.providers.OAuth1Info

case class Profile(
                    loginInfo: LoginInfo,
                    confirmed: Boolean,
                    email: Option[String],
                    firstName: Option[String],
                    lastName: Option[String],
                    fullName: Option[String],
                    passwordInfo: Option[PasswordInfo],
                    oauthInfo: Option[OAuth1Info],
                    avatarUrl: Option[String]
                  )