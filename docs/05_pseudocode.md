# 5. Pseudocode

## Algorithm A

```text
BUILD_HEAP_A(A)
    H = empty heap

    for each x in A
        append x to H
        HEAPIFY_UP(H, last index)

    return H
```

```text
HEAPIFY_UP(H, i)
    while i > 0
        p = (i - 1) / 2

        if H[p] >= H[i]
            break

        swap H[p] and H[i]
        i = p
```

## Algorithm B

```text
BUILD_HEAP_B(A)
    H = copy of A

    for i = floor(n/2)-1 down to 0
        HEAPIFY_DOWN(H, i)

    return H
```

```text
HEAPIFY_DOWN(H, i)
    while true
        left = 2*i + 1
        right = 2*i + 2
        largest = i

        if left exists and H[left] > H[largest]
            largest = left

        if right exists and H[right] > H[largest]
            largest = right

        if largest == i
            break

        swap H[i] and H[largest]
        i = largest
```
