# Unit Testing Samples

## Git

### Show commits

    git log --oneline
    git log -n <count> --oneline

### Checkout commit

    git checkout <commit>

### Remove unstaged changes

    git checkout .
    git checkout -- .

### Stash unstaged changes and untracked files

    git stash -k -u 
    
#### Unstash 

    git stash pop
    
#### Drop stash

    git stash drop

### Remove untracked files

#### Verify what is going to be deleted

    git clean -n    

#### Clean interactive to avoid mistakes    
        
    git clean -i    
    
#### Clean all files and directories

    git clean -f -d
    git clean -fd
    
> Note: `-d` can be added to all above

### Remove staged changes

    git reset HEAD

### Create new branch

    git checkout -b <branch>
    git add .
    git commit -m "<message>"