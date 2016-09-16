package FileSearcher
import java.io.File

import org.scalatest.FlatSpec

class FilterCheckerTest extends FlatSpec {

  "FilterChecker passed a list where one file matches the filter" should "return a list with the file" in {
    val listOfFiles = List(FileObject(new File("random")), FileObject(new File("match")))
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfFiles
    assert(matchedFiles == List(FileObject(new File("match"))))
  }

  "FileChecker passed a list with a directory that matches filter" should "should not return directory" in {
    val listOfObjects = List(FileObject(new File("random")),
      DirectoryObject(new File("match")))
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfObjects
    assert(matchedFiles.isEmpty)
  }

  "FilterChecker passed a file with content that matched the filter" should "return a 3" in {
    val isContentMatched = FilterChecker("pluralsight").findMatchedContentCount(new File("./testfiles/pluralsight.data"))
    assert(isContentMatched == 3)
    }

  "FilterChecker passed a file with content that does not matched the filter" should "return a 0" in {
    val isContentMatched = FilterChecker("pluralsight").findMatchedContentCount(new File("./testfiles/readme.txt"))
    assert(isContentMatched == 0)
  }
}


