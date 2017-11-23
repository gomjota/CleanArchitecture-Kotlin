package com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.getComics

import com.google.gson.annotations.SerializedName
import java.util.*


class NetworkGetComicsResponse(@SerializedName("data") val data: NetworkData)

class NetworkData(@SerializedName("offset") val offset: Int,
                  @SerializedName("limit") val limit: Int,
                  @SerializedName("total") val total: Int,
                  @SerializedName("count") val count: Int,
                  @SerializedName("results") val results: List<NetworkResult>)

class NetworkResult(@SerializedName("id") val id: Int? = null,
                    @SerializedName("title") val title: String? = null,
                    @SerializedName("description") val description: String? = null,
                    @SerializedName("pageCount") val pageCount: Int? = null,
                    @SerializedName("dates") val dates: List<NetworkDate>? = null,
                    @SerializedName("prices") val prices: List<NetworkPrice>? = null,
                    @SerializedName("thumbnail") val thumbnail: NetworkThumbnail? = null,
                    @SerializedName("images") val images: List<NetworkImage>? = null,
                    @SerializedName("creators") val creators: NetworkCreators? = null,
                    @SerializedName("characters") val characters: NetworkCharacters? = null)

class NetworkDate(@SerializedName("type") val type: String,
                  @SerializedName("date") val date: String)

class NetworkPrice(@SerializedName("type") val type: String,
                   @SerializedName("price") val price: Float)

class NetworkThumbnail(@SerializedName("path") val path: String,
                       @SerializedName("extension") val extension: String)

class NetworkImage(@SerializedName("path") val path: String,
                   @SerializedName("extension") val extension: String)

class NetworkCreators(@SerializedName("items") val creators: List<NetworkCreator>)

class NetworkCreator(@SerializedName("resourceURI") val resourceURI: String,
                     @SerializedName("name") val name: String,
                     @SerializedName("role") val role: String)

class NetworkCharacters(@SerializedName("items") val characters: List<NetworkCharacter>)

class NetworkCharacter(@SerializedName("resourceURI") val resourceURI: String,
                       @SerializedName("name") val name: String)
