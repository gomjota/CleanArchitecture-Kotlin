package com.github.juan1393.cleanArchitectureKotlin.data.entity

class ComicEntity(val id: Int? = null,
                  val title: String? = null,
                  val description: String? = null,
                  val pageCount: Int? = null,
                  val printPrice: Float? = null,
                  val thumbnailUrl: String? = null,
                  val imagesUrl: List<String>? = null,
                  var creators: List<CreatorEntity>? = null,
                  var characters: List<CharacterEntity>? = null)