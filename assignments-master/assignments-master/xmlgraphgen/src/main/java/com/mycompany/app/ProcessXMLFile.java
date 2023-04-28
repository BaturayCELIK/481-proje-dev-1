package com.mycompany.app;

import com.mycompany.app.graph.ConsoleGraphFactory;
import com.mycompany.app.graph.GraphvizGraphFactory;
import com.mycompany.app.graph.IGraphFactory;

import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.Format;
import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

public class ProcessXMLFile {

  public static void main(String argv[]) {
    String xmlFileName = argv[0];
    IGraphFactory graphFactory = new ConsoleGraphFactory();
    if (argv.length > 1) {
      graphFactory = new GraphvizGraphFactory();
    }
    try {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      DefaultHandler handler = new GraphHandler(graphFactory);

      saxParser.parse(xmlFileName, handler);

      if (argv.length > 1) {
        String dotSpec = (String) ((GraphHandler) handler).getResult();
        System.out.println(dotSpec);

        if (argv.length > 2) {
          Graphviz.fromString(dotSpec)
              .width(200)
              .render(Format.PNG)
              .toFile(new File(argv[2]));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

