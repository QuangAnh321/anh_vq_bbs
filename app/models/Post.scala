package models

import org.joda.time.DateTime
import scalikejdbc.WrappedResultSet
import skinny.orm.feature.associations.Association
import skinny.orm.{ Alias, SkinnyCRUDMapper }

case class Post(id: Int, title: String, content: String, userId: Int, createdAt: DateTime, user: Option[User] = None)

object Post extends SkinnyCRUDMapper[Post] {
  override def defaultAlias: Alias[Post] = createAlias("p")
  override lazy val tableName = "post"
  private[this] lazy val p = defaultAlias
  val userRef: Association[Post] = belongsTo[User](User, (p, u) => p.copy(user = u)).byDefault

  //Easier to understand version
  //  val userRef = belongsTo[User](
  //    right = User,
  //    merge = (post, user) => post.copy(user = user)
  //  )
  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[Post]): Post = new Post(
    id = rs.get(n.id),
    title = rs.get(n.title),
    content = rs.get(n.content),
    userId = rs.get(n.userId),
    createdAt = rs.get(n.createdAt)
  )

}

