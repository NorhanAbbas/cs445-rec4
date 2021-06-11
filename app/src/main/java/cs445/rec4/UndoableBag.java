package cs445.rec4;

import java.lang.UnsupportedOperationException;

/**
 * A class that implements the Bag ADT with undo/redo
 * capabilities by extending ArrayBag
 * @author Brian Nixon
 * @author William C. Garrison III
 */

public class UndoableBag<E> extends ArrayBag<E> {
    private StackInterface<Action<E>> undoStack;
    private StackInterface<Action<E>> redoStack;

    /**
     * Creates an empty bag with default capacity.
     */
    public UndoableBag() {
        // Call ArrayBag Default Constructor
        super();

        undoStack = new LinkedStack<Action<E>>();
        redoStack = new LinkedStack<Action<E>>();
    }

    /**
     * Adds a new entry to this bag.
     * @param newEntry  The object to be added as a new entry.
     * @return  True if the item is added, false otherwise.
     */
    @Override
    public boolean add(E newEntry) {
        // use ArrayBag add method
        boolean result = super.add(newEntry);

        // If it worked, update stacks
        if (result) {
            redoStack.clear();

            // keep track of insertion for future undo operations
            Action<E> inserted = new Action<E>('i', newEntry);
            undoStack.push(inserted);
        }

        return result;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return  Either the removed entry, if the removal was successful, or
     * null.
     */
    @Override
    public E remove() {
        // Call ArrayBag remove method
        E removedItem = super.remove();

        // If it worked, update stacks
        if (removedItem != null) {
            redoStack.clear();

            // keep track of removal for future undo operations
            Action<E> removed = new Action<E>('r', removedItem);
            undoStack.push(removed);
        }

        return removedItem;
    }

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * @param anEntry  The entry to be removed.
     * @return  True if the removal was successful, or false if not.
     */
    @Override
    public boolean remove(E anEntry) {
        // Call ArrayBag remove method
        boolean result = super.remove(anEntry);

        // If it worked, update stacks
        if (result) {
            redoStack.clear();

            Action<E> removed = new Action<E>('r', anEntry);
            undoStack.push(removed);
        }

        return result;
    }

    /**
     * Removes all entries from this bag.
     */
    @Override
    public void clear() throws UnsupportedOperationException {
        // How might you implement this for undo/redo?
        // Consider why this is more difficult.
        throw new UnsupportedOperationException("Clear method not supported");
    }

    /**
     * Undoes the last insertion/removal operation that was performed on this bag, if possible.
     * @return True if the undo was successful, or false if there was nothing to undo.
     */
    public boolean undo() {
        if (undoStack.isEmpty()) {
            return false;
        }
        Action<E> operation = undoStack.pop();
        // keep track of undone operations for future redo operations
        redoStack.push(operation);

        // the opposite operation should be performed
        switch (operation.getAction()) {
            case 'i':
                return super.remove(operation.getData());
            case 'r':
                return super.add(operation.getData());
            default:
                // this would be a weird error case
                return false;
        }
    }

    /**
     * Redoes the last undo operation that was performed on this bag, if possible.
     * @return True if the redo was successful, or false if there was nothing to redo.
     */
    public boolean redo() {
        if (redoStack.isEmpty()) {
            return false;
        }
        Action<E> operation = redoStack.pop();
        // keep track of redone operations for future undo operations
        undoStack.push(operation);

        // the same operation should be performed
        switch (operation.getAction()) {
            case 'i':
                return super.add(operation.getData());
            case 'r':
                return super.remove(operation.getData());
            default:
                // this would be a weird error case
                return false;
        }
    }

}

