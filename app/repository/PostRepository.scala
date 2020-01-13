package repository

import models.Post

import scala.util.Try

class PostRepository {

  def getAll() = Try {
    Post.findAll()
  }

  def getById(id: Int): Option[Post] = {
    try {
      Post.findById(id)
    } catch {
      case _: Exception => throw new Exception("Not Found")
    }
  }
}
