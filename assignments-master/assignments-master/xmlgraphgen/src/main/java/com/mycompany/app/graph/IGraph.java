package com.mycompany.app.graph;

public interface IGraph {
  void addNode(String id, String label, String color);
  void addTransition(String fromId, String toId, String label, String color);
  Object done();
}