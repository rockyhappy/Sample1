package com.devrachit.swiggy_xml_imdb.presentation.list_screen

import com.devrachit.swiggy_xml_imdb.domain.models.SearchResult

data class States (
    var isLoading: Boolean = false,
    var list : SearchResult = SearchResult(emptyList()),
    )