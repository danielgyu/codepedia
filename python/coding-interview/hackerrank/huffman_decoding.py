def decodeHuff(root, s):
    decoded = ""
    
    idx = 0
    while idx < len(s):
        node = root
        
        while True:
            if node.left is None and node.right is None:
                break
            
            digit = s[idx]
            if digit == "0":
                node = node.left
            else:
                node = node.right
            idx += 1
                
        decoded += node.data
    
    print(decoded)
