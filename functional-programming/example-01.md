
```

people = [{ 'name': 'Mary', 'height': 160 },
    { 'name': 'Isla', 'height': 80 },
    { 'name': 'Sam' }
]

height_total = 0
height_count = 0
for person in people:
    if 'height' in person:
    height_total += person['height']
height_count += 1

if height_count > 0:
    average_height = height_total / height_count

print average_height# => 120

```


```

people = [{ 'name': 'Mary', 'height': 160 },
    { 'name': 'Isla', 'height': 80 },
    { 'name': 'Sam' }
]

peopleWithHeight = filter(lambda x: 'height' in x, people)

if peopleWithHeight.length > 0 {
	totalHeight = reduce(lambda a, x: a + x['height'], peopleWithHeight, 0)
	print totalHeight / peopleWithHeight.length
}

```
