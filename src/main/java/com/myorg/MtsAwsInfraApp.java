package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class MtsAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        MtsVpcStack mtsVpcStack = new MtsVpcStack(app, "Vpc");
        MtsClusterStack mtsClusterStack = new MtsClusterStack(app, "cluster", mtsVpcStack.getVpc());

        mtsClusterStack.addDependency(mtsVpcStack); //para evitar conflitos,caso o cluster seja construido antes da vpc, ele ficara esperando
        
        app.synth();
    }
}

