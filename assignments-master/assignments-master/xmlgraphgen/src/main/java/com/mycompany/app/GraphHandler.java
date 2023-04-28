package com.mycompany.app;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.mycompany.app.graph.IGraph;
import com.mycompany.app.graph.IGraphFactory;

class GraphHandler extends DefaultHandler {

  public Object getResult() {
    return ""; // graph.done()
  }
  
  public GraphHandler(IGraphFactory graphFactory) {
     
  } // constructor

  public void startElement(
    String uri, String localName, String qName, Attributes attributes)
  throws SAXException {
    // <node>:
    //  graph = graphFactory.newGraph(attributes.getValue("title"));
  } // method startElement

  public void endElement(String uri, String localName, String qName)
  throws SAXException {
    //</transition>
    //    graph.addTransition(from, to, label, color);
    //</node>
    //    graph.addNode(id, label, color);
  }

  public void characters(char ch[], int start, int length)
  throws SAXException {
    String data = new String(ch, start, length);
  }
} // class GraphHandler