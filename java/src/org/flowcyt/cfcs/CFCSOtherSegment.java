package org.flowcyt.cfcs;
// CFCSOtherSegment.java

/* ------------------------------------------------------------------------- *\
This software and documentation are provided 'as is' and Tree Star, Inc., its
contractors and partners specifically disclaim all other warranties, expressed
or implied, including but not limited to implied warranties of merchantability
and fitness for a particular purpose, or during any particular date range.

By using this software, you are agreeing to these limits of liability, and to
hold Tree Star harmless for any information, accurate or erroneous, that might
be generated by the program.  This software is intended for research use only.

Christopher Lane <cdl@best.classes> for Tree Star  1/14/2002      Copyright 2002
\* ------------------------------------------------------------------------- */

public final class CFCSOtherSegment implements Cloneable, CFCSErrorCodes
{

    private byte[] data;

    // --------------------------------------------------------------------

    /* friendly */
    final CFCSOtherSegment copy()
    {
        CFCSOtherSegment duplicate = null;

        try
        {
            duplicate = (CFCSOtherSegment) this.clone();
        }
        catch (CloneNotSupportedException exception)
        {
            throw new CFCSError(CFCSSystemError, exception);
        }

        return duplicate;
    }

    // --------------------------------------------------------------------
    // Returns the number of bytes in the segment.

    public final int getCount()
    {
        return data.length;
    }

    // --------------------------------------------------------------------
    // Returns the bytes of the OTHER segment.  The data array should be at
    // least getCount() bytes long otherwise an exception is thrown.

    public final void getBytes(final byte[] data)
    {
        final int length = (this.data).length;

        if (data.length < length)
        {
            throw new CFCSError(CFCSInsufficientSpace, data.length);
        }
        /* else */ System.arraycopy(this.data, 0, data, 0, length);
    }

    // --------------------------------------------------------------------
    // Copies the content of the the data array into the OTHER segment.

    public final void setBytes(final byte[] data)
    {
        final int length = data.length;

        this.data = new byte[length];
        System.arraycopy(data, 0, this.data, 0, length);
    }

    // --------------------------------------------------------------------

}
