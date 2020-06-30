package com.test.provercast.repository.network.entity.api

data class Pagemap(
    val aggregaterating: List<Aggregaterating>,
    val cse_image: List<CseImage>,
    val cse_thumbnail: List<CseThumbnail>,
    val hcard: List<Hcard>,
    val imageobject: List<Imageobject>,
    val person: List<Person>,
    val videoobject: List<Videoobject>,
    val xfn: List<Xfn>
)