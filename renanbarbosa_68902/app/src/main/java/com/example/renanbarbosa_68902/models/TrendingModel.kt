package com.example.renanbarbosa_68902.models

class TrendingModel {
    @JvmField
    var name: String? = null
    @JvmField
    var description: String? = null
    @JvmField
    var rating: String? = null
    var type: String? = null
    @JvmField
    var imageURL: String? = null

    constructor()
    constructor(
        name: String?,
        description: String?,
        rating: String?,
        type: String?,
        imageURL: String?
    ) {
        this.name = name
        this.description = description
        this.rating = rating
        this.type = type
        this.imageURL = imageURL
    }
}
