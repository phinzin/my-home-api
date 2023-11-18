package com.phinzin.myhome.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosDiagnosticsHandler;
import com.azure.cosmos.CosmosDiagnosticsThresholds;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.cosmos.GatewayConnectionConfig;
import com.azure.cosmos.models.CosmosClientTelemetryConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;

@Configuration
@EnableCosmosRepositories
public class AzureCosmosDbConfiguration extends AbstractCosmosConfiguration {

    @Value("${azure.cosmos.uri}")
    private String uri;

    @Value("${azure.cosmos.key}")
    private String key;

    @Value("${azure.cosmos.secondaryKey}")
    private String secondaryKey;

    @Value("${azure.cosmos.database}")
    private String dbName;

    private AzureKeyCredential azureKeyCredential;

    @Override
    protected String getDatabaseName() {
        return this.dbName;
    }
    @Bean
    public CosmosClientBuilder getCosmosClientBuilder() {
        this.azureKeyCredential = new AzureKeyCredential(key);
        DirectConnectionConfig directConnectionConfig = new DirectConnectionConfig();
        GatewayConnectionConfig gatewayConnectionConfig = new GatewayConnectionConfig();
        return new CosmosClientBuilder()
            .endpoint(uri)
            .credential(azureKeyCredential)
            .directMode(directConnectionConfig, gatewayConnectionConfig)
            .clientTelemetryConfig(
                new CosmosClientTelemetryConfig()
                    .diagnosticsThresholds(
                        new CosmosDiagnosticsThresholds()
                            // .setNonPointOperationLatencyThreshold(Duration.ofMillis(nonPointOperationLatencyThresholdInMS))
                            // .setPointOperationLatencyThreshold(Duration.ofMillis(pointOperationLatencyThresholdInMS))
                            // .setPayloadSizeThreshold(payloadSizeThresholdInBytes)
                            // .setRequestChargeThreshold(requestChargeThresholdInRU)
                    )
                    .diagnosticsHandler(CosmosDiagnosticsHandler.DEFAULT_LOGGING_HANDLER));
    }
}
