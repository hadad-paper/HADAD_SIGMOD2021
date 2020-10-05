package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Part of nested block tree data structure.
 *
 * Represents the supported models.
 */
public abstract class Model {
    /* The model unique identifier. */
    private final String id;
    /* The model format. */
    private final Format format;
    /* The model language. */
    private final Language language;
    /* The model block encoder. */
    private final BlockEncoder blockEncoder;
    /* The model nested block tree builder. */
    private final QueryBlockTreeBuilder queryBlockTreeBuilder;

    /**
     * Constructs a new model with the specified format and language.
     *
     * @param id
     *            the model unique identifier.
     * @param format
     *            the model format.
     * @param language
     *            the model language.
     * @param blockDecoder
     *            the model block encoder.
     * @param queryBlockTreeBuilder
     *            the model nested block tree builder.
     */
    protected Model(final String id, Format format, Language language,
            final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
        this.id = checkNotNull(id);
        this.format = checkNotNull(format);
        this.language = checkNotNull(language);
        this.queryBlockTreeBuilder = checkNotNull(queryBlockTreeBuilder);
        this.blockEncoder = checkNotNull(blockEncoder);
    }

    /**
     * This model unique identifier.
     *
     * @return this model unique identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * This model format.
     *
     * @return this model format.
     */
    public Format getFormat() {
        return format;
    }

    /**
     * This model language.
     *
     * @return the model language.
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * This model block encoder.
     *
     * @return the model block encoder.
     */
    public BlockEncoder getBlockEncoder() {
        return blockEncoder;
    }

    /**
     * This model nested block tree builder.
     *
     * @return the model nested block tree builder.
     */
    public QueryBlockTreeBuilder getNestedBlockTreeBuilder() {
        return queryBlockTreeBuilder;
    }
}
