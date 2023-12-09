FROM bellsoft/liberica-openjdk-alpine:11.0.16.1-1
COPY ./src ./src
RUN mkdir ./out && javac -sourcepath ./src -d out src/ru/gb/jcore/sample/Main.java
CMD java -classpath ./out ru.gb.jcore.sample.Main