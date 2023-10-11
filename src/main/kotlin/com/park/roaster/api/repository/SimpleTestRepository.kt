package com.park.roaster.api.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository
import java.io.Serializable

interface SimpleTestRepository : JpaRepository<SimpleTestModel, Long>

@Entity
@Table(name = "simple_model")
data class SimpleTestModel(
    @Id
    @Column(name = "model_id", nullable = false)
    var modelId: Long,
    @Column(name = "model_name", nullable = false)
    var modelName: String,
) : Serializable {
    companion object
}
