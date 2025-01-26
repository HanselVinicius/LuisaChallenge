package com.vinicius.challenge.configuration.security

import com.vinicius.challenge.core.application.auth.gateway.GetSubjectGateway
import org.junit.jupiter.api.Assertions.assertNotNull
import org.mockito.kotlin.mock
import kotlin.test.Test

class GetSubjectConfigTest {
    @Test
    fun shouldCreateGetSubjectServiceBean() {
        // Arrange
        val getSubjectConfig = GetSubjectConfig()
        val getSubjectGateway = mock<GetSubjectGateway>()
        // Act
        val result = getSubjectConfig.getSubjectService(getSubjectGateway)
        // Assert
        assertNotNull(result)
    }
}
