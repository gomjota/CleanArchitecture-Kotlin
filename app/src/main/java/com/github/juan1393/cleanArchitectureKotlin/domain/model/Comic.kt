package com.github.juan1393.cleanArchitectureKotlin.domain.model

import java.io.Serializable


class Comic(val id: Int? = null,
            val title: String? = null,
            val description: String? = null,
            val pageCount: Int? = null,
            val releaseDate: String? = null,
            val printPrice: Float? = null,
            val thumbnailUrl: String? = null,
            val imagesUrl: List<String>? = null,
            var creators: List<Creator>? = null,
            var characters: List<Character>? = null) : Serializable {

    fun hasAllInfo(): Boolean {
        return (id != null && id > 0 && title != null && description != null && releaseDate != null && thumbnailUrl != null
                && imagesUrl != null && !imagesUrl.isEmpty())
    }
}