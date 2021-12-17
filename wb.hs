import Q3Example
import Types

import qualified Data.List as List
import qualified Data.Maybe as Maybe
main = do 

  print (parentDir bc1 == Just bc2)
  print ()

  let t1 = T1 98
  let t2 = T2 "sdds"
  let t3 = "sdds"
  isT2 t2
  print (t2 == t3)

  return ()
  --let ret = take 20 (cross 5 (repeat True))
  --let ret2 = take 20 (sequenceFrom 2 (cross 3 (repeat True)))
  --print ret
  --print ret2
  --let ret3 = take 20 (sieveFrom 5 (repeat True))
  --print $ take 20 (sieveFrom 2 (repeat True))
  --print $ take 20 (sieveFrom 3 (repeat True))
  --print $ take 20 (sieveFrom 4 (repeat True))
  --print $ take 20 (sieveFrom 5 (repeat True))
  --print [1..]
  return ()

cross :: Int -> [Bool] -> [Bool]
cross n bs = take (n - 1) bs ++ [False] ++ cross n (drop n bs)

sieveFrom :: Int -> [Bool] -> [Bool]
sieveFrom n (h:bs) = h : sieveFrom (n + 1) (cross n bs)

sequenceFrom :: Int -> [Bool] -> [Int]
sequenceFrom _ [] = []
sequenceFrom n (x:xs) = if x
  then n : sequenceFrom (n + 1) xs
  else sequenceFrom (n + 1) xs


bsand (h1:bs1) (h2:bs2) = (h1 && h2) :bsand bs1 bs2


parentDir :: Breadcrumb -> Maybe Breadcrumb
parentDir (_, []) = Nothing 
parentDir (x, h : xs) = Just (Dir{dirName = enteredDirName h, dirContents = entriesBefore h ++ [DirEntry x] ++ entriesAfter h}, xs)


getind :: String -> Directory -> Maybe Int
getind str dir=List.findIndex (\e -> ck e && (dirName (e as DirEntry) == str) ) (dirContents dir)
--(dirContents (fst bs)) -- [DirectoryEntry]

ck :: DirectoryEntry -> Bool 
ck (DirEntry _ ) = True 
ck (FileEntry _) = False 


--getName :: DirectoryEntry -> String 
--getName (DirEntry _ ) = dirName (Directory _ )
--getName (FileEntry _) = fileName (File _ )

data Te = 
      T1 Int
    | T2 String
 deriving (Eq,Show)

openSubDir :: String -> Breadcrumb -> Maybe Breadcrumb
openSubDir str (dir, []) = Nothing
openSubDir str (dir, entered@(top: xs)) = 
  let ED {
        entriesBefore = before,
        enteredDirName = enteredName,
        entriesAfter = after
      } = top
      
      findFn :: DirectoryEntry -> Bool
      findFn (DirEntry x) = (dirName x == str)
      findFn (FileEntry x) = False
      
      found :: Maybe DirectoryEntry
      found = List.find findFn $ before ++ after
      
      f :: DirectoryEntry -> Maybe Directory
      f (DirEntry x) = Just x
      f (FileEntry x) = Nothing
      
      g :: Directory -> Breadcrumb
      g d@(Dir {
        dirName = str,
        dirContents = list
      }) = (d, [
        ED {
          entriesBefore = [],
          enteredDirName = str,
          entriesAfter = list
        }
        ] ++ entered)
  in fmap g $ found >>= f