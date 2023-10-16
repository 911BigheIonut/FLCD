class HashTable:
    def __init__(self, size):
        self.size = size
        self.table = [[] for _ in range(size)]

    def _hash(self, key):
        ascii_sum = sum(ord(char) for char in key)
        position = ascii_sum % self.size
        return position, ascii_sum

    def insert(self, key, value):
        position, _ = self._hash(key)
        self.table[position].append((key, value, position))

    def retrieve(self, key):
        position, _ = self._hash(key)
        for k, v, pos in self.table[position]:
            if k == key:
                return v, pos  # Return the value and the position where it was stored
        return None, None



# Example usage
hash_table = HashTable(size=1028)
hash_table.insert('a', 47)
hash_table.insert('b', 100)
hash_table.insert('ab', 102)
hash_table.insert('d', 142)

# Retrieve and print value and position for 'a' and 'b'
value_a, position_a = hash_table.retrieve('a')
value_b, position_b = hash_table.retrieve('b')
value_ab, position_ab = hash_table.retrieve('ab')
value_d, position_d = hash_table.retrieve('d')

print(f"Value for 'a': {value_a}, Position: {position_a}")
print(f"Value for 'b': {value_b}, Position: {position_b}")
print(f"Value for 'ab': {value_ab}, Position: {position_ab}")
print(f"Value for 'd': {value_d}, Position: {position_d}")
