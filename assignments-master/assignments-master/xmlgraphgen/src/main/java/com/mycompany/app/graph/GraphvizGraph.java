package com.mycompany.app.graph;

public class GraphvizGraph implements IGraph {
  StringBuffer _buffer = new StringBuffer();
  /** Resources:
   *  http://www.graphviz.org/content/dot-language
   *  http://graphs.grevian.org/example
   *  http://www.graphviz.org/doc/info/shapes.html
   *  http://www.webgraphviz.com/
   */

  public GraphvizGraph(String title) {
    _buffer.append("digraph {\n");
    _buffer.append("node [fontcolor=red fontsize=32 width=0.5 shape=circle];");
    _buffer.append(String.format("label=\"%s\";\n", title));
  }

  @Override
  public void addNode(String id, String label, String color) {
    _buffer.append(
      String.format("%s [label=\"%s\", color=\"%s\"];\n", id, label, color));
  }

  @Override
  public void addTransition(
      String fromId, String toId, String label, String color) {
    _buffer.append(
        String.format(
            "%s -> %s [label=\"%s\", color=\"%s\"];\n",
            fromId,
            toId,
            label,
            color));
  }

  @Override
  public Object done() {
    _buffer.append("}");
    return _buffer.toString();
  }
}