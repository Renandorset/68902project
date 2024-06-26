package com.example.renanbarbosa_68902.models

class CategoryModel {
    @JvmField
    var name: String? = null
    @JvmField
    var type: String? = null
    @JvmField
    var image_url: String? = null

    constructor()
    constructor(name: String?, type: String?, imageURL: String?) {
        this.name = name
        this.type = type
        image_url = imageURL
    }
}
