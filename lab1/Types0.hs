module Types where
import GHC.Show (Show)

data File = File {
    fileName :: String,
    fileContents :: String
} deriving (Eq,Show)

data Directory = Dir{
    dirName :: String,
    dirContents ::[ DirectoryEntry ]
} deriving (Eq,Show)

data DirectoryEntry = 
      FileEntry File
    | DirEntry Directory
 deriving (Eq,Show)

data EnteredDirectory = ED {
    entriesBefore :: [DirectoryEntry],
    enteredDirName :: String,
    entriesAfter :: [DirectoryEntry]
} deriving (Eq,Show)

type Breadcrumb = (Directory, [EnteredDirectory])