package perf;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.index.*;
import org.apache.lucene.store.*;

public class OpenCloseIndexWriter {
  public static void main(String[] args) throws IOException {
    final String dirPath = args[0];
    final Directory dir = new MMapDirectory(new File(dirPath).toPath());
    final Analyzer a = new StandardAnalyzer(CharArraySet.EMPTY_SET);
    final IndexWriterConfig iwc = new IndexWriterConfig(a);
    final IndexWriter writer = new IndexWriter(dir, iwc);
    writer.close();
    dir.close();
  }
}
