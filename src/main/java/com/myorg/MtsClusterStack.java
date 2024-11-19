package com.myorg;

import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ecs.Cluster;


public class MtsClusterStack extends Stack {
    public MtsClusterStack(final Construct scope, final String id, final Vpc vpc) {
        this(scope, id, null, vpc);
    }

    public MtsClusterStack(final Construct scope, final String id, final StackProps props, final Vpc vpc) {
        super(scope, id, props);

        Cluster cluster = Cluster.Builder.create(this, "MtsCluster")
        		.clusterName("cluster-michael")//opcional
                .vpc(vpc)
                .build();
    }
}
