package com.example.giupokedex.data.datasource.mappers.base

import com.example.giupokedex.data.datasource.remote.modelresponse.base.StatDetailResponse
import com.example.giupokedex.domain.models.base.StatDetail

fun StatDetailResponse.toStatDetailDomainModel() = StatDetail(
    id = id ?: 0,
    name = name.orEmpty()
)