package net.alvo.v1;

import java.io.Reader;

public interface Resource {
   Reader getText();

   String getLocation();

   InstructionSource getResult(ExecutionContext var1) throws AlvoException;
}
