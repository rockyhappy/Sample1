package com.devrachit.swiggy_xml_imdb.domain.models

import com.devrachit.swiggy_xml_imdb.data.remote.dto.Title

data class SearchResult(
    val titles: List<Title>
)
