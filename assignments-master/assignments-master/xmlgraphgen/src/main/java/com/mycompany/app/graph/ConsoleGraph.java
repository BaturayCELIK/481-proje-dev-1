package com.mycompany.app.graph;

public class ConsoleGraph implements IGraph {
  public ConsoleGraph(String title) {
    System.out.printf("Graph title=%s\n", title);
  }

  @Override
  public void addNode(String id, String label, String color) {
    System.out.printf("node id: %s; label=%s; color=%s\n",
                      id,
                      label,
                      color);
  }

  @Override
  public void addTransition(
      String fromId, String toId, String label, String color) {
    System.out.printf("transition from=%s; to=%s; label=%s; color=%s\n",
                      fromId,
                      toId,
                      label,
                      color);
  }

  @Override
  public Object done() {
    return null;
  }
}