/*
 * Copyright (c) PRGX.
 * All Rights Reserved.
 */
package uk.co.eduardo.math.geom;

/**
 * Represents a 2x2 matrix.
 *
 * @author erodri02
 */
public class Matrix2
{
   /** The 2 x 2 identity matrix. */
   public static final Matrix2 IDENTITY = new Matrix2( 1, 0, 0, 1 );

   /** Element at row 0 column 0. */
   public final double a00;

   /** Element at row 0 column 1. */
   public final double a01;

   /** Element at row 1 column 0. */
   public final double a10;

   /** Element at row 1 column 1. */
   public final double a11;

   /**
    * Initializes a new Matrix3 object.
    * <p>
    * Constructs the following matrix:
    *
    * <pre>
    *  &#x250C;          &#x2510;
    *  &#x2502; a00, a01 &#x2502;
    *  &#x2502; a10, a11 &#x2502;
    *  &#x2514;          &#x2518;
    * </pre>
    * </p>
    *
    * @param a00 element at row 0 column 0.
    * @param a01 element at row 0 column 1.
    * @param a10 element at row 1 column 0.
    * @param a11 element at row 1 column 1.
    */
   public Matrix2( final double a00, final double a01, final double a10, final double a11 )
   {
      this.a00 = a00;
      this.a01 = a01;
      this.a10 = a10;
      this.a11 = a11;
   }

   /**
    * Calculates the result vector, r, by multiplying this matrix, M, with the specified vector, v:
    *
    * <pre>
    * r = M.v
    * </pre>
    *
    * @param v the vector with which to multiply this matrix.
    * @return the vector multiplied by this matrix.
    */
   public Vector2 mul( final Vector3 v )
   {
      final double r0 = ( this.a00 * v.x ) + ( this.a01 * v.y );
      final double r1 = ( this.a10 * v.x ) + ( this.a11 * v.y );
      return new Vector2( r0, r1 );
   }

   /**
    * Calculates the result matrix, R, by multiplying this matrix, M, with the specified matrix, S:
    *
    * <pre>
    * R = M.S
    * </pre>
    *
    * @param S the matrix with which to compose this matrix.
    * @return the composition of this matrix and the other.
    */
   public Matrix2 mul( final Matrix2 S )
   {
      final double r00 = ( this.a00 * S.a00 ) + ( this.a01 * S.a10 );
      final double r01 = ( this.a00 * S.a01 ) + ( this.a01 * S.a11 );

      final double r10 = ( this.a10 * S.a00 ) + ( this.a11 * S.a10 );
      final double r11 = ( this.a10 * S.a01 ) + ( this.a11 * S.a11 );

      return new Matrix2( r00, r01, r10, r11 );
   }

   /**
    * Calculates the result matix, R, by multiplying this matix, M, with the specified scalar, f.
    *
    * <pre>
    * R = M.f
    * </pre>
    *
    * @param factor the scale factor by which to multiply each element of this matrix.
    * @return the result of multiplying each element of this matrix by the scale factor.
    */
   public Matrix2 mul( final double factor )
   {
      return new Matrix2( this.a00 * factor, this.a01 * factor, this.a10 * factor, this.a11 * factor );
   }

   /**
    * Calculates the determinant of this matrix.
    *
    * @return the determinant of the matrix.
    */
   public double det()
   {
      return ( this.a00 * this.a11 ) - ( this.a01 * this.a10 );
   }

   /**
    * Calculates the inverse of the matrix, <code>M<sup>-1</sup></code>
    *
    * @return the matrix inverse or <code>null</code> if the inverse could not be calculated.
    */
   public Matrix2 inv()
   {
      final double det = det();
      if( det == 0 )
      {
         return null;
      }

      return new Matrix2( this.a11, -this.a01, -this.a10, this.a00 ).mul( 1 / det );
   }

   /**
    * Returns the transpose of this matrix, <code>M<sup>T</sup></code>.
    *
    * @return the transpose of this matrix.
    */
   public Matrix2 transpose()
   {
      return new Matrix2( this.a00, this.a10, this.a01, this.a11 );
   }

   /**
    * Creates a rotation matrix.
    *
    * @param theta the number of degrees by which to rotate.
    * @return a rotation matrix.
    */
   public static Matrix2 createRotationMatrix( final double theta )
   {
      final double ct = Math.cos( Math.toRadians( theta ) );
      final double st = Math.sin( Math.toRadians( theta ) );

      return new Matrix2( ct, -st, st, ct );
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return String.format( "| %.3f, %.3f |\n| %.3f, %.3f |", //$NON-NLS-1$
                            this.a00,
                            this.a01,
                            this.a10,
                            this.a11 );
   }
}
