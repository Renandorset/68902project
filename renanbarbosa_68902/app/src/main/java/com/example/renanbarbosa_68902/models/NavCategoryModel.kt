package com.example.renanbarbosa_68902.models

class NavCategoryModel {
    @JvmField
    var name: String? = null
    @JvmField
    var img_url: String? = null

    constructor()
    constructor(name: String?, img_url: String?) {
        this.name = name
        this.img_url = img_url
    }
}
