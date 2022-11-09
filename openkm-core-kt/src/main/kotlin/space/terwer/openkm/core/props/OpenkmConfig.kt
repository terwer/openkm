package space.terwer.openkm.core.props

import lombok.Data
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.bind.DefaultValue
import org.springframework.stereotype.Component

@ConstructorBinding
@ConfigurationProperties(prefix = "openkm")
data class  OpenkmConfig (
    val pluginSwitch:String
)