package com.devrachit.swiggy_xml_imdb.domain.usecase

import com.devrachit.swiggy_xml_imdb.data.remote.dto.SearchReasultDto
import com.devrachit.swiggy_xml_imdb.data.remote.mappers.toSearchResult
import com.devrachit.swiggy_xml_imdb.domain.models.SearchResult
import com.devrachit.swiggy_xml_imdb.domain.repository.ApiServicesRepository
import com.devrachit.swiggy_xml_imdb.utility.Resource
import com.devrachit.swiggy_xml_imdb.utility.safeApiCall
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SearchTitles @Inject constructor(
    private val repository : ApiServicesRepository
)
{
    operator fun invoke(expression : String) : Flow<Resource<SearchResult>> = flow {
        emit(Resource.Loading())
        val result = safeApiCall { repository.searchTitles(expression).toSearchResult() }
        emit(result)
    }
}