package com.devrachit.swiggy_xml_imdb.data.remote.mappers

import com.devrachit.swiggy_xml_imdb.data.remote.dto.SearchReasultDto
import com.devrachit.swiggy_xml_imdb.domain.models.SearchResult

fun SearchReasultDto.toSearchResult(): SearchResult
{
    return SearchResult(
        titles = this.titles
    )
}