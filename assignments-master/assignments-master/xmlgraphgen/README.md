Build

```
mvn compile
mvn package
```

Run

1) Run with console output (Console graph)

```
java -cp target/myDemoApp-1.0-SNAPSHOT.jar com.mycompany.app.ProcessXMLFile resources/graph.xml
```

Expected output:

```
Graph title=A
node id: 2000; label=aa; color=blue
node id: 1000; label=b; color=black
node id: 3000; label=c; color=purple
transition from=1000; to=2000; label=m1(); color=yellow
transition from=3000; to=1000; label=m2(); color=black
transition from=3000; to=2000; label=m3(); color=orange
```


2) Run with graphviz (Graphviz graph)

```
java -cp target/myDemoApp-1.0-SNAPSHOT.jar com.mycompany.app.ProcessXMLFile resources/graph.xml graphviz
```

Expected output:

```
digraph {
node [fontcolor=red fontsize=32 width=0.5 shape=circle];label="A";
2000 [label="aa", color="blue"];
1000 [label="b", color="black"];
3000 [label="c", color="purple"];
1000 -> 2000 [label="m1()", color="yellow"];
3000 -> 1000 [label="m2()", color="black"];
3000 -> 2000 [label="m3()", color="orange"];
}
```


3) Run with graphviz to generate a png

```
mvn exec:java -Dexec.mainClass="com.mycompany.app.ProcessXMLFile" -Dexec.args="resources/graph.xml graphviz output/test.png"
```

The output image test.png will be available under output/ folder.


![image](https://user-images.githubusercontent.com/12052/32127861-64da5238-bb82-11e7-8bd8-71099f8caf7d.png)
