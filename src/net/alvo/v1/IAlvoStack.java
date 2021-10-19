package net.alvo.v1;

import java.util.NoSuchElementException;

public interface IAlvoStack {
   int height();

   AlvoObject pop() throws NoSuchElementException;

   void push(AlvoObject var1);

   AlvoObject top() throws NoSuchElementException;
}
