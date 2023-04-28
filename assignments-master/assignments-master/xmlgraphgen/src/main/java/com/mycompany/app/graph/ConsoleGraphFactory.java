package com.mycompany.app.graph;

public class ConsoleGraphFactory implements IGraphFactory {
  @Override
  public IGraph newGraph(String title) {
    return new ConsoleGraph(title);
  }
}