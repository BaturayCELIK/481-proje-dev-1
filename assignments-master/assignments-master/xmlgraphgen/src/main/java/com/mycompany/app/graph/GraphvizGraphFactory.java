package com.mycompany.app.graph;

public class GraphvizGraphFactory implements IGraphFactory {
  @Override
  public IGraph newGraph(String title) {
    return new GraphvizGraph(title);
  }
}