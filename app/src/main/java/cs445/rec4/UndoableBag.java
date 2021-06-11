package cs445.rec4;

import java.lang.UnsupportedOperationException;

/*****
 * A class that implements the Bag ADT with undo/redo
 * capabilities by extending ArrayBag
 * @author Brian Nixon
 * @author William C. Garrison III
 */

public class UndoableBag<E> extends ArrayBag<E> {
    // TODO Create two stack reference variables called undoStack and redoStack

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

        // TODO keep track of added entry for undo operations

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

        // TODO keep track of the item removed for later undo operations

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

        // TODO keep track of the item removed for later undo operations

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
        // TODO implement the undo method (including fixing the return value)

        return false;
    }

    /**
     * Redoes the last undo operation that was performed on this bag, if possible.
     * @return True if the redo was successful, or false if there was nothing to redo.
     */
    public boolean redo() {
        // TODO implement the redo method (including fixing the return value)

        return false;
    }

}

