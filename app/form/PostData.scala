package form

import play.api.data.Form
import play.api.data.Forms._

case class PostData(title: String, content: String)

class PostForm {
  val createPostForm: Form[PostData] = Form(
    mapping(
      "title" -> text,
      "content" -> text
    )(PostData.apply)(PostData.unapply)
  )

}