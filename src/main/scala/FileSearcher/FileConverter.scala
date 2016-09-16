package FileSearcher

import java.io.File

object FileConverter {
  def convertToIOObjects(file: File) =
    if(file.isDirectory) DirectoryObject(file)
    else FileObject(file)
}
