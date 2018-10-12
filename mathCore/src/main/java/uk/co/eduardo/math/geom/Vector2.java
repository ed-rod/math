/*
 * Copyright (c) PRGX.
 * All Rights Reserved.
 */
package uk.co.eduardo.math.geom;

/**
 * Represents a 2D vector.
 *
 * @author erodri02
 */
public class Vector2
{
   /** Zero vector. */
   public static final Vector2 ZERO = new Vector2( 0, 0 );

   /** Unit vector in the X direction. */
   public static final Vector2 X = new Vector2( 1, 0 );

   /** Unit vector in the Y direction. */
   public static final Vector2 Y = new Vector2( 0, 1 );

   /** The x component. */
   public final double x;

   /** The y component. */
   public final double y;

   /**
    * Initializes a new Vector2 object.
    *
    * @param x the x component.
    * @param y the y component.
    */
   public Vector2( final double x, final double y )
   {
      this.x = x;
      this.y = y;
   }

   /**
    * Computes the L2 norm of the vector.
    *
    * @return returns a unit vector.
    */
   public Vector2 normalize()
   {
      final double length = length();
      return new Vector2( this.x / length, this.y / length );
   }

   /**
    * Calculates the Euclidian distance of the vector.
    *
    * @return the length of the vector.
    */
   public double length()
   {
      return Math.sqrt( ( this.x * this.x ) + ( this.y * this.y ) );
   }

   /**
    * Returns this + other. Computes:
    *
    * <pre>
    *  &#x250C;                  &#x2510;
    *  &#x2502; this.x + other.x &#x2502;
    *  &#x2502; this.y + other.y &#x2502;
    *  &#x2514;                  &#x2518;
    * </pre>
    *
    * @param other the other operand. Cannot be <code>null</code>.
    * @return this + other.
    */
   public Vector2 add( final Vector2 other )
   {
      return new Vector2( this.x + other.x, this.y + other.y );
   }

   /**
    * Returns this - other. Computes:
    *
    * <pre>
    *  &#x250C;                  &#x2510;
    *  &#x2502; this.x - other.x &#x2502;
    *  &#x2502; this.y - other.y &#x2502;
    *  &#x2514;                  &#x2518;
    * </pre>
    *
    * @param other the other operand. Cannot be <code>null</code>.
    * @return this - other.
    */
   public Vector2 sub( final Vector2 other )
   {
      return new Vector2( this.x - other.x, this.y - other.y );
   }

   /**
    * Returns this * factor. Computes:
    *
    * <pre>
    *  &#x250C;                 &#x2510;
    *  &#x2502; this.x * factor &#x2502;
    *  &#x2502; this.y * factor &#x2502;
    *  &#x2514;                 &#x2518;
    * </pre>
    *
    * @param factor the scale factor.
    * @return this * other.
    */
   public Vector2 mul( final double factor )
   {
      return new Vector2( this.x * factor, this.y * factor );
   }

   /**
    * Returns this / factor. Computes:
    *
    * <pre>
    *  &#x250C;                 &#x2510;
    *  &#x2502; this.x / factor &#x2502;
    *  &#x2502; this.y / factor &#x2502;
    *  &#x2514;                 &#x2518;
    * </pre>
    *
    * @param factor the scale factor.
    * @return this / other.
    */
   public Vector2 div( final double factor )
   {
      return new Vector2( this.x / factor, this.y / factor );
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return String.format( "[%.3f, %.3f]", this.x, this.y ); //$NON-NLS-1$
   }
}
