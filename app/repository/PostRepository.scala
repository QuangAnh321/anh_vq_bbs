package repository

import models.Post

import scala.util.Try

class PostRepository {

  def getAll() = Try {
    Post.findAll()
  }

  def getById(id: Int) = Try {
    Post.findById(id)
  }
}
