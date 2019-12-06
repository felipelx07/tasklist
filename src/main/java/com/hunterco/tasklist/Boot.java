package com.hunterco.tasklist;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;

public class Boot {

  public static void main(String... args) throws Exception {
    Swarm swarm = new Swarm(args);
    swarm.fraction(new DatasourcesFraction().dataSource("H2DS", (ds) -> {
      ds.driverName("h2");
    }));
    swarm.start().deploy();
  }
}
