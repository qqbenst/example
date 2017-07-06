package com.example.demo.dao.impl.jpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class JpaLimitSuport implements Pageable, Serializable {

	private static final long serialVersionUID = -25822477129613575L;

    private int limit;
    private int offset;
    private final Sort sort;

    /**
     * Creates a new {@link OffsetBasedPageRequest} with sort parameters applied.
     *
     * @param offset zero-based offset.
     * @param limit  the size of the elements to be returned.
     * @param sort   can be {@literal null}.
     */
    public JpaLimitSuport(int offset, int limit, Sort sort) {
        if (offset < 0) {
            throw new IllegalArgumentException("Offset index must not be less than zero!");
        }

        if (limit < 1) {
            throw new IllegalArgumentException("Limit must not be less than one!");
        }
        this.limit = limit;
        this.offset = offset;
        this.sort = sort;
    }

    /**
     * Creates a new {@link OffsetBasedPageRequest} with sort parameters applied.
     *
     * @param offset     zero-based offset.
     * @param limit      the size of the elements to be returned.
     * @param direction  the direction of the {@link Sort} to be specified, can be {@literal null}.
     * @param properties the properties to sort by, must not be {@literal null} or empty.
     */
    public JpaLimitSuport(int offset, int limit, Sort.Direction direction, String... properties) {
        this(offset, limit, new Sort(direction, properties));
    }

    /**
     * Creates a new {@link OffsetBasedPageRequest} with sort parameters applied.
     *
     * @param offset zero-based offset.
     * @param limit  the size of the elements to be returned.
     */
     public JpaLimitSuport(int offset, int limit) {
        this(offset, limit, new Sort(Sort.Direction.ASC,"id"));
    }

    @Override
    public int getPageNumber() {
        return 0 ;
    }

    @Override
    public int getPageSize() {
        return offset + limit;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return new JpaLimitSuport(getOffset() + getPageSize(), getPageSize(), getSort());
    }

    public JpaLimitSuport previous() {
        return hasPrevious() ? new JpaLimitSuport(getOffset() - getPageSize(), getPageSize(), getSort()) : this;
    }


    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public Pageable first() {
        return new JpaLimitSuport(0, getPageSize(), getSort());
    }

    @Override
    public boolean hasPrevious() {
        return offset > limit;
    }

    @Override
    public boolean equals(Object o) {
    	

		if (this == o) {
			return true;
		}

		if (!(o instanceof JpaLimitSuport)) {
			return false;
		}

		JpaLimitSuport that = (JpaLimitSuport) o;

		boolean sortEqual = this.sort == null ? that.sort == null : this.sort.equals(that.sort);

		return super.equals(that) && sortEqual;

    }

    @Override
    public int hashCode() {
		return 31 * super.hashCode() + (null == sort ? 0 : sort.hashCode());
    }

	@Override
	public String toString() {
		return "JpaLimitSuport [limit=" + limit + ", offset=" + offset + ", sort=" + sort + "]";
	}

}
